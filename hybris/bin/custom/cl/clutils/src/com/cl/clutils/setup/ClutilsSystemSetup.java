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
package com.cl.clutils.setup;

import static com.cl.clutils.constants.ClutilsConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.clutils.constants.ClutilsConstants;
import com.cl.clutils.service.ClutilsService;


@SystemSetup(extension = ClutilsConstants.EXTENSIONNAME)
public class ClutilsSystemSetup
{
	private final ClutilsService clutilsService;

	public ClutilsSystemSetup(final ClutilsService clutilsService)
	{
		this.clutilsService = clutilsService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		clutilsService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ClutilsSystemSetup.class.getResourceAsStream("/clutils/sap-hybris-platform.png");
	}
}
