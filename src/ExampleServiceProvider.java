package edu.mayo.cts2.framework.plugin.service.example;

import java.util.Set;

import edu.mayo.cts2.framework.core.config.PluginConfig;
import edu.mayo.cts2.framework.core.config.option.Option;
import edu.mayo.cts2.framework.service.profile.Cts2Profile;
import edu.mayo.cts2.framework.service.profile.codesystem.CodeSystemQueryService;
import edu.mayo.cts2.framework.service.profile.codesystem.CodeSystemReadService;
import edu.mayo.cts2.framework.service.provider.ServiceProvider;

public class ExampleServiceProvider implements ServiceProvider {

	private ExampleCodeSystemCatalogReadService service = 
			new ExampleCodeSystemCatalogReadService();
	
	private ExampleCodeSystemQueryService query = 
			new ExampleCodeSystemQueryService();
	
	@SuppressWarnings("unchecked")
	public <T extends Cts2Profile> T getService(Class<T> clazz) {
		
		if(clazz == CodeSystemReadService.class){
			//return back our service if it is asked for
			return (T) service;
		} else if(clazz == CodeSystemQueryService.class){
			//return back our service if it is asked for
			return (T) query;
		} else {
			//return null for all others
			return null;
		}
	
	}

	public Set<Option> getPluginOptions() {
		//no plugin-specific options defined
		return null;
	}

	public void initialize(PluginConfig config) {
		//no initialization needed for example
	}

	public void destroy() {
		//nothing to cleanup for example
	}
}
