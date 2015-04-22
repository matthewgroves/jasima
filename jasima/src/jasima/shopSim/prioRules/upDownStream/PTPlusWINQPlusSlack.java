/*******************************************************************************
 * Copyright (c) 2010-2015 Torsten Hildebrandt and jasima contributors
 *
 * This file is part of jasima, v1.2.
 *
 * jasima is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jasima is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jasima.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package jasima.shopSim.prioRules.upDownStream;

import jasima.shopSim.core.PR;
import jasima.shopSim.core.PrioRuleTarget;

/**
 * This class implements the PT+WINQ+SL rule, developed by Rajendran and
 * Holthaus (1999), which extends PT+WINQ by taking into account the slack of a
 * job.
 * 
 * @author Christoph Pickardt, 2011-11-15
 * @version 
 *          "$Id$"
 */
public class PTPlusWINQPlusSlack extends PR {

	private static final long serialVersionUID = -7220017849004140341L;

	@Override
	public double calcPrio(PrioRuleTarget j) {
		return -(j.getCurrentOperation().procTime + WINQ.winq(j) + Math.min(
				j.getDueDate() - j.getShop().simTime() - j.remainingProcTime(),
				0.0d));
	}

}
