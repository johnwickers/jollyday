/**
 * Copyright 2010 Sven Diedrichsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 * @author sven
 * @version $Id: $
 */
package de.jollyday.util;

import de.jollyday.HolidayType;
import de.jollyday.config.Month;
import de.jollyday.config.Weekday;
import de.jollyday.spi.Unmarshaller;

import java.time.DayOfWeek;
import java.util.ServiceLoader;

public class XMLUtil {

    /**
     * Uses {@link ServiceLoader} mechanism to lookup {@link Unmarshaller}
     * implementations.
     *
     * @return The first {@link Unmarshaller}.
     */
	public Unmarshaller loadUnmarshaller() {
        ServiceLoader<Unmarshaller> loader = ServiceLoader.load(Unmarshaller.class);
        if (!loader.iterator().hasNext()) {
            throw new IllegalStateException("Cannot find Unmarshaller service.");
        }
        return loader.iterator().next();
    }

	/**
	 * Returns the {@link DayOfWeek} equivalent for the given weekday.
	 *
	 * @param weekday
	 *            a {@link Weekday} object.
	 * @return a DayOfWeek instance.
	 */
	public final DayOfWeek getWeekday(Weekday weekday) {
		return DayOfWeek.valueOf(weekday.name());
		}

	/**
	 * Returns the value for the given month.
	 *
	 * @param month
	 *            a {@link Month} object.
	 * @return a 1-12 value.
	 */
	public int getMonth(Month month) {
		return month.ordinal() + 1;
	}

	/**
	 * Gets the type.
	 *
	 * @param type
	 *            the type of holiday in the config
	 * @return the type of holiday
	 */
	public HolidayType getType(de.jollyday.config.HolidayType type) {
	    if (type == null) {
            return HolidayType.OFFICIAL_HOLIDAY;
        }
		switch (type) {
            case OFFICIAL_HOLIDAY:
                return HolidayType.OFFICIAL_HOLIDAY;
            case UNOFFICIAL_HOLIDAY:
                return HolidayType.UNOFFICIAL_HOLIDAY;
            default:
                throw new IllegalArgumentException("Unknown type " + type);
		}
	}

}
