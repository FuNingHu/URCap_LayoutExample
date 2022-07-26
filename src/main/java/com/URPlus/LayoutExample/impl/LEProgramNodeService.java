package com.URPlus.LayoutExample.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.data.DataModel;

public class LEProgramNodeService implements SwingProgramNodeService<LEProgramNodeContribution, LEProgramNodeView>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "LE-Node";
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {
		// TODO Auto-generated method stub
		configuration.setChildrenAllowed(false);
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return "Layout Example";
	}

	@Override
	public LEProgramNodeView createView(ViewAPIProvider apiProvider) {
		// TODO Auto-generated method stub
		SystemAPI systemAPI = apiProvider.getSystemAPI();
		Locale local = systemAPI.getSystemSettings().getLocalization().getLocaleForProgrammingLanguage();
		Style style = systemAPI.getSoftwareVersion().getMajorVersion() >=5? new V5Style() : new V3Style();
		
		return new LEProgramNodeView(apiProvider, style, local);
	}

	@Override
	public LEProgramNodeContribution createNode(ProgramAPIProvider apiProvider, LEProgramNodeView view, DataModel model,
			CreationContext context) {
		// TODO Auto-generated method stub
		return new LEProgramNodeContribution(apiProvider, view, model);
	}

}
