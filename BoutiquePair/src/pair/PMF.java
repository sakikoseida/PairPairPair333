package pair;

import javax.jdo.*;

public class PMF {
		private static final PersistenceManagerFactory factory =
				JDOHelper.getPersistenceManagerFactory("transactions-optional");
		
		private PMF() {}
		
		public static PersistenceManagerFactory get() {
			return factory;
		}

}
