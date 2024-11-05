package util;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public final class ApplicationParams {

		private Properties props;
		private String nomeProperties;
		
		public ApplicationParams(String nomeProperties){
			loaderProperties(nomeProperties);
		}
		
		private void loaderProperties(String nomeProperties) {
			props = new Properties();
			final InputStream in = this.getClass().getResourceAsStream(nomeProperties);
			try {
				props.load(in);
				in.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		
		public String getProperty(String chave) {
			return props.getProperty(chave);
		}
		/**
		 * Retorna a propriedade nomeProperties.
		 * @return propriedade nomeProperties.
		 */
		public String getNomeProperties() {
			return nomeProperties;
		}
		/**
		 * Estabelece um novo valor a propriedade nomeProperties.
		 * @param nomeProperties: novo valor para a propriedade nomeProperties.
		 */
		public void setNomeProperties(String nomeProperties) {
			this.nomeProperties = nomeProperties;
		}
	}
