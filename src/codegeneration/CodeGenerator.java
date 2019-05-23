package codegeneration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

	BufferedWriter writer;
	int labels = 0;
	private int line = -1;

	public CodeGenerator() throws IOException {
		writer = new BufferedWriter(new FileWriter("generatedCode.txt"));
		writer.write("#source \"input.txt\"");
		writer.newLine();
	}

	/*
	 * ************************
	 * 
	 * PUSH AND POP INSTRUCTIONS
	 * 
	 * ************************
	 */
	public void push(String suffix, int value) {
		try {
			writer.write("\tpush" + suffix + "\t" + value);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void push(String suffix, double value) {
		try {
			writer.write("\tpush" + suffix + "\t" + value);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void pop(String suffix) {
		try {
			writer.write("\tpop" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	/*
	 * ************************
	 * 
	 * ARITHMETIC OPERATIONS
	 * 
	 * ************************
	 */
	public void add(String suffix) {
		try {
			writer.write("\tadd" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void sub(String suffix) {
		try {
			writer.write("\tsub" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void mul(String suffix) {
		try {
			writer.write("\tmul" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void div(String suffix) {
		try {
			writer.write("\tdiv" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void mod(String suffix) {
		try {
			writer.write("\tmod" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	/*
	 * ************************
	 * 
	 * COMPARISSON OPERATIONS
	 * 
	 * ************************
	 */
	public void gt(String suffix) {
		try {
			writer.write("\tgt" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void lt(String suffix) {
		try {
			writer.write("\tlt" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void ge(String suffix) {
		try {
			writer.write("\tge" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void le(String suffix) {
		try {
			writer.write("\tle" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void eq(String suffix) {
		try {
			writer.write("\teq" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void ne(String suffix) {
		try {
			writer.write("\tne" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	/*
	 * ************************
	 * 
	 * LOGICAL OPERATIONS
	 * 
	 * ************************
	 */
	public void and(String suffix) {
		try {
			writer.write("\tand");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void or(String suffix) {
		try {
			writer.write("\tor");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void not() {
		try {
			writer.write("\tnot");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	/*
	 * ************************
	 * 
	 * INPUT/OUTPUT OPERATIONS
	 * 
	 * ************************
	 */
	public void in(String suffix) {
		try {
			writer.write("\tin" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void out(String suffix) {
		try {
			writer.write("\tout" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void load(String suffix) {
		try {
			writer.write("\tload" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void store(String suffix) {
		try {
			writer.write("\tstore" + suffix);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	/*
	 * ************************
	 * 
	 * JUMPS AND LABELS
	 * 
	 * ************************
	 */

	public void label(int labelNumber) {
		try {
			writer.write("label" + labelNumber + ":");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}

	}

	public int getLabels(int i) {
		int label = labels;
		labels += i;
		return label;
	}

	public void jz(int labelNumber) {
		try {
			writer.write("\tjz\t" + "label" + labelNumber);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void jmp(int labelNumber) {
		try {
			writer.write("\tjmp\t" + "label" + labelNumber);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	/*
	 * ************************
	 * 
	 * THE REST
	 * 
	 * ************************
	 */

	public void callMain() {
		try {
			writer.newLine();
			writer.write("call main");
			writer.newLine();
			writer.write("halt");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void bp() {
		try {
			writer.write("\tpush\tbp");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void comment(String message) {
		try {
			writer.write("\t' * " + message);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void id(String name) {
		try {
			writer.write("\n" + name + ": ");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void enter(int numberOfBytes) {
		try {
			writer.write("\tenter\t" + numberOfBytes);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void ret(int numberOfBytes, int localVariablesSize, int parametersSize) {
		try {
			writer.write("\tret\t" + numberOfBytes + ", " + localVariablesSize + ", " + parametersSize);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void call(String name) {
		try {
			writer.write("\tcall\t" + name);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void line(int line) {
		try {
			if (this.line != line) {
				writer.write("\n#line\t" + line);
				writer.newLine();
				this.line = line;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void convert(String suffix1, String suffix2) {
		try {
			if (!(suffix1.equals("i") || suffix2.equals("i"))) {
				writer.write("\t" + suffix1 + "2" + "i");
				writer.newLine();
				writer.write("\t" + "i" + "2" + suffix2);
				writer.newLine();
			} else {
				writer.write("\t" + suffix1 + "2" + suffix2);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("There was an IO error generating the code.");
		}
	}

}
