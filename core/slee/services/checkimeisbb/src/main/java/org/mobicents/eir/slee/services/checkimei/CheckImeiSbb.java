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

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.IMEI;
import org.mobicents.protocols.ss7.map.api.service.mobility.MAPDialogMobility;
import org.mobicents.protocols.ss7.map.api.service.mobility.imei.CheckImeiRequest;
import org.mobicents.protocols.ss7.map.api.service.mobility.imei.EquipmentStatus;

/**
 * 
 * @author normandes
 *
 */
public abstract class CheckImeiSbb extends CheckImeiCommonSbb {

	public CheckImeiSbb() {
		super(CheckImeiSbb.class.getSimpleName());
	}

	public void onCheckImeiRequest(CheckImeiRequest event, ActivityContextInterface aci) {
		IMEI imei = event.getIMEI();

		EquipmentStatus equipmentStatus = EquipmentStatus.whiteListed;

		// TODO: Query database to check IMEI list
		sendCheckImeiResponse(event, equipmentStatus);
	}

	private void sendCheckImeiResponse(CheckImeiRequest event, EquipmentStatus equipmentStatus) {
		try {
			MAPDialogMobility dialog = event.getMAPDialog();
			dialog.addCheckImeiResponse(event.getInvokeId(), equipmentStatus, null, null);

			dialog.close(false);
		} catch (MAPException e) {
			this.tracer.severe("Error while sending CheckImeiResponse.", e);
		}
	}

}
