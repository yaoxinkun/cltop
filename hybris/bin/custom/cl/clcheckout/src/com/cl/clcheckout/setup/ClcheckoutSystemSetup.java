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
package com.cl.clcheckout.setup;

import static com.cl.clcheckout.constants.ClcheckoutConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.clcheckout.constants.ClcheckoutConstants;
import com.cl.clcheckout.service.ClcheckoutService;


@SystemSetup(extension = ClcheckoutConstants.EXTENSIONNAME)
public class ClcheckoutSystemSetup
{
	private final ClcheckoutService clcheckoutService;

	public ClcheckoutSystemSetup(final ClcheckoutService clcheckoutService)
	{
		this.clcheckoutService = clcheckoutService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		clcheckoutService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ClcheckoutSystemSetup.class.getResourceAsStream("/clcheckout/sap-hybris-platform.png");
	}
}
