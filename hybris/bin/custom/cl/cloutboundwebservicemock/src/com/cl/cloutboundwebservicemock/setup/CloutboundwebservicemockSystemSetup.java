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
package com.cl.cloutboundwebservicemock.setup;

import static com.cl.cloutboundwebservicemock.constants.CloutboundwebservicemockConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.cloutboundwebservicemock.constants.CloutboundwebservicemockConstants;
import com.cl.cloutboundwebservicemock.service.CloutboundwebservicemockService;


@SystemSetup(extension = CloutboundwebservicemockConstants.EXTENSIONNAME)
public class CloutboundwebservicemockSystemSetup
{
	private final CloutboundwebservicemockService cloutboundwebservicemockService;

	public CloutboundwebservicemockSystemSetup(final CloutboundwebservicemockService cloutboundwebservicemockService)
	{
		this.cloutboundwebservicemockService = cloutboundwebservicemockService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		cloutboundwebservicemockService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CloutboundwebservicemockSystemSetup.class.getResourceAsStream("/cloutboundwebservicemock/sap-hybris-platform.png");
	}
}
