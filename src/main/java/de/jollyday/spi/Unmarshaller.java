package de.jollyday.spi;

import de.jollyday.config.Configuration;

import java.io.InputStream;

/**
 * SPI interface to support different XML binding frameworks.
 *
 * @author sdiedrichsen
 * @since 07.05.18
 */
public interface Unmarshaller {

    Configuration unmarshallConfiguration(InputStream stream);

}
