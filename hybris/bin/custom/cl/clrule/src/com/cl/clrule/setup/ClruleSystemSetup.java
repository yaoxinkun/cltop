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
package com.cl.clrule.setup;

import static com.cl.clrule.constants.ClruleConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cl.clrule.constants.ClruleConstants;
import com.cl.clrule.service.ClruleService;


@SystemSetup(extension = ClruleConstants.EXTENSIONNAME)
public class ClruleSystemSetup
{
	private final ClruleService clruleService;

	public ClruleSystemSetup(final ClruleService clruleService)
	{
		this.clruleService = clruleService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		clruleService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ClruleSystemSetup.class.getResourceAsStream("/clrule/sap-hybris-platform.png");
	}
}
