package symbolTable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	//private int scope=0;
	private List<Map<String,Definition>> table;
	
	public SymbolTable()  {
		table = new ArrayList<Map<String,Definition>>();
		table.add(new HashMap<String,Definition>());
	}

	public void set() {
		table.add(new HashMap<String,Definition>());
		//scope++;
	}
	
	public void reset() {
		table.remove(getScope());
		//scope--;
	}
	
	private int getScope() {
		return table.size()-1;
	}

	public boolean insert(Definition definition) {
		// Cambiar esto el put modifica el previous value
		if(table.get(getScope()).get(definition.getName()) == null) {
			definition.setScope(getScope());
			table.get(getScope()).put(definition.getName(), definition);
			return true;
		}
		//Throw err or smth
		return false;
	}
	
	public Definition find(String id) {
		int localScope = getScope();
		while(localScope>=0) {
			Definition d = table.get(localScope).get(id);
			if(d!=null)
				return d;
			localScope--;
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(getScope()).get(id);
	}
}
