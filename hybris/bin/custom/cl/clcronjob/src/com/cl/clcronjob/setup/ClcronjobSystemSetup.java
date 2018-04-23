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
package com.cl.clcronjob.setup;

import static com.cl.clcronjob.constants.ClcronjobConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.clcronjob.constants.ClcronjobConstants;
import com.cl.clcronjob.service.ClcronjobService;


@SystemSetup(extension = ClcronjobConstants.EXTENSIONNAME)
public class ClcronjobSystemSetup
{
	private final ClcronjobService clcronjobService;

	public ClcronjobSystemSetup(final ClcronjobService clcronjobService)
	{
		this.clcronjobService = clcronjobService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		clcronjobService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ClcronjobSystemSetup.class.getResourceAsStream("/clcronjob/sap-hybris-platform.png");
	}
}
