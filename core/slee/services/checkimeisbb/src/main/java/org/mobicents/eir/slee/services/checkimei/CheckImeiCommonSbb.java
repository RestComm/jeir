/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.eir.slee.services.checkimei;

import javax.slee.ActivityContextInterface;
import javax.slee.CreateException;
import javax.slee.RolledBackContext;
import javax.slee.Sbb;
import javax.slee.SbbContext;
import javax.slee.facilities.Tracer;

import org.mobicents.slee.SbbContextExt;

/**
 * 
 * @author normandes
 *
 */
public abstract class CheckImeiCommonSbb implements Sbb {

	private final String className;
	
	protected Tracer tracer;
	protected SbbContextExt sbbContext;
	
	public CheckImeiCommonSbb(String className) {
		this.className = className;
	}
	
	@Override
	public void setSbbContext(SbbContext sbbContext) {
		this.sbbContext = (SbbContextExt) sbbContext;
		
		this.tracer = this.sbbContext.getTracer(this.className);
	}
	
	@Override
	public void sbbActivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbCreate() throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbExceptionThrown(Exception e, Object obj,
			ActivityContextInterface aci) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbPassivate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbPostCreate() throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbRemove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbRolledBack(RolledBackContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sbbStore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsetSbbContext() {
		// TODO Auto-generated method stub
		
	}

}
