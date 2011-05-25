package org.lejos.nxt.ldt.wizard;

import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageTwo;

public class NewPCProject extends AbstractNewProjectWizard {

	public NewPCProject() {
		super();
		pageOne = new NewPCProjectPageOne();
		pageTwo = new NewJavaProjectWizardPageTwo(pageOne);
		
		pageOne.setTitle("New LeJOS NXT Project");
		pageOne.setDescription("Create a new LeJOS Project for programs running on the NXT");
		
	    setWindowTitle("New LeJOS NXT Project");
	}
}
