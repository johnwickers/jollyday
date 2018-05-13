package de.jollyday.util;

import de.jollyday.config.Configuration;
import de.jollyday.spi.Unmarshaller;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import java.io.InputStream;

/**
 * @author sdiedrichsen
 * @version $Id$
 * @since 07.05.18
 */
public class JiBXUnmarshaller implements Unmarshaller {

    /**
   	 * Unmarshalls the configuration from the stream. Uses <code>JiBX</code> for
   	 * this.
   	 *
   	 * @param stream an {@link java.io.InputStream} object.
   	 * @return The unmarshalled configuration.
   	 */
    @Override
   	public Configuration unmarshallConfiguration(InputStream stream) {
   		if (stream == null) {
   			throw new IllegalArgumentException("Stream is NULL. Cannot read XML.");
   		}
   		try {
   			IBindingFactory factory = BindingDirectory.getFactory(Configuration.class);
   			IUnmarshallingContext ctx = factory.createUnmarshallingContext();
   			return (Configuration) ctx.unmarshalDocument(stream, "UTF-8");
   		} catch (JiBXException ue) {
   			throw new IllegalStateException("Cannot parse holidays XML file.", ue);
   		}
   	}

}
