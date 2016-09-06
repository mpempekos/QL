package org.uva.sea.ql.type_checker;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.expression.Literal.Identifier;
import org.uva.sea.ql.type_checker.type.Type;

public class IdentifierData {

		private final Type type;
		private final String label;
		private final Set<Identifier> dependencies;
		
		public IdentifierData(Type type, String label) {
			this.type = type;
			this.label = label;
			this.dependencies = new HashSet<Identifier>();
		}		
		
		public Type getType() {
			return this.type;
		}
		
		public String getLabel() {
			return this.label;
		}


		public Set<Identifier> getDependencies() {
			return dependencies;
		}
		
		public void setDependencies(Identifier dependency) {
			this.dependencies.add(dependency);
		}
		
}