package com.berico;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * A simple class that will initialize a Drools
 * knowledge session for deriving classes.  This
 * class forces deriving classes to supply a rule
 * file as a requirement of building the session.
 * 
 * @author Richard Clayton (Berico Technologies)
 */
public abstract class BaseApp 
{
	/**
	 * A preinitialized knowledge session derived
	 * classes will use to perform their tasks.
	 */
	private StatefulKnowledgeSession session = null;
	
	/**
	 * Force derived classes to use a getter just in 
	 * case we decide to do something special on access
	 * in the future.
	 * @return initialized knowledge session.
	 */
	protected StatefulKnowledgeSession getSession(){
		return this.session;
	}
	
	/**
	 * Deriving classes must supply a rule file
	 * that will be used by the knowledge builder.
	 * @return Name of the rule file
	 */
	protected abstract String getRuleFile();
	
	/**
	 * Instantiate the application, initializing
	 * the knowledge session.
	 */
	public BaseApp(){
		
		initializeSession();
	}
	
	/**
	 * Initialize the Rules Engine Session.
	 */
	private void initializeSession(){
		
		// The knowledge builder is used to compile rule and
		// workflow (BPM) resources into executable code.
		// If types are declared in the rule file, they
		// will also be compiled as Java classes.
		KnowledgeBuilder kbuilder = 
				KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		// Get the rule file supplied by deriving classes.
		// This file will be pulled from the class path.
		Resource ruleFile = ResourceFactory.newClassPathResource(
				this.getRuleFile());
		
		// Add the rule file to the knowledge builder.
		kbuilder.add(ruleFile, ResourceType.DRL);
		
		// Initialize a knowledge base from the knowledge builder.
		// The knowledge base is a container for the known logic 
		// of the rules engine.
		KnowledgeBase knowledgeBase = kbuilder.newKnowledgeBase();
		
		// Initialize a rules/workflow session from the knowledge
		// base.  This is the construct we will use to insert
		// "facts" in the rules engine, apply/evaluate
		// rules, and then react to the results.
		this.session = knowledgeBase.newStatefulKnowledgeSession();
		
		// Log actions occurring in the session to the console.
		KnowledgeRuntimeLoggerFactory.newConsoleLogger(session);
		
		// Log actions occurring in the session to a file.
		KnowledgeRuntimeLoggerFactory.newFileLogger(session, 
				String.format(
					"rule_session_%s.xml", 
					System.currentTimeMillis()));
	}
}
