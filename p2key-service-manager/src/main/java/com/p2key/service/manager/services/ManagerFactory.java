package com.p2key.service.manager.services;

import com.p2key.service.security.services.AuthManager;

public class ManagerFactory {
	private static ServiceManager serviceManager = null;
	private static OwnerManager ownerManager = null;
	private static PromotionManager promotionManager = null;
	private static AuthManager authManager = null;

	protected ManagerFactory() {
	}
	
	public static ServiceManager getServiceManager() {
		if(serviceManager == null) {
			serviceManager = new ServiceManager();
		}
		return serviceManager;
	}
	
	public static OwnerManager getOwnerManager() {
		if(ownerManager == null) {
			ownerManager = new OwnerManager();
		}
		return ownerManager;
	}
	
	public static PromotionManager getPromotionManager() {
		if(promotionManager == null) {
			promotionManager = new PromotionManager();
		}
		return promotionManager;
	}
	
	public static AuthManager getAuthManager() {
		if(authManager == null) {
			authManager = new AuthManager();
		}
		return authManager;
	}
}
