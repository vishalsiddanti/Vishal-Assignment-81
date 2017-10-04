package com.boot.drools.react.droolsconfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.stereotype.Component;

import com.boot.drools.react.model.Decision;

@Component
public class DroolsConfig {
	
	public Decision executeDrools(int score) throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rules/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Decision decision = new Decision();
		decision.setScore(score);

		workingMemory.insert(decision);
		workingMemory.fireAllRules();

		System.out.println("The Decision " + decision.getDesc()
				+ " is " + decision.getScore());
		return decision;
	}

}
