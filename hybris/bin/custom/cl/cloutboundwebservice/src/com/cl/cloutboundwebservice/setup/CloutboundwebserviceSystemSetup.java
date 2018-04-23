/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.cl.cloutboundwebservice.setup;

import static com.cl.cloutboundwebservice.constants.CloutboundwebserviceConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.cloutboundwebservice.constants.CloutboundwebserviceConstants;
import com.cl.cloutboundwebservice.service.CloutboundwebserviceService;


@SystemSetup(extension = CloutboundwebserviceConstants.EXTENSIONNAME)
public class CloutboundwebserviceSystemSetup
{
	private final CloutboundwebserviceService cloutboundwebserviceService;

	public CloutboundwebserviceSystemSetup(final CloutboundwebserviceService cloutboundwebserviceService)
	{
		this.cloutboundwebserviceService = cloutboundwebserviceService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		cloutboundwebserviceService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CloutboundwebserviceSystemSetup.class.getResourceAsStream("/cloutboundwebservice/sap-hybris-platform.png");
	}
}
