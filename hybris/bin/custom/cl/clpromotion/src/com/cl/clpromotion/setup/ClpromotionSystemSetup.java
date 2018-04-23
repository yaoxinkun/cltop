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
package com.cl.clpromotion.setup;

import static com.cl.clpromotion.constants.ClpromotionConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.clpromotion.constants.ClpromotionConstants;
import com.cl.clpromotion.service.ClpromotionService;


@SystemSetup(extension = ClpromotionConstants.EXTENSIONNAME)
public class ClpromotionSystemSetup
{
	private final ClpromotionService clpromotionService;

	public ClpromotionSystemSetup(final ClpromotionService clpromotionService)
	{
		this.clpromotionService = clpromotionService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		clpromotionService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ClpromotionSystemSetup.class.getResourceAsStream("/clpromotion/sap-hybris-platform.png");
	}
}
