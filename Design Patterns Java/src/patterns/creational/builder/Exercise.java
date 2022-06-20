package patterns.creational.builder;

import java.util.ArrayList;

class Attribute
{
	String type;
	String name;
	
	public Attribute(String name, String type) {
		this.type = type;
		this.name = name;
	}	
}

class CodeBuilder
{
	private String className;
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	
    public CodeBuilder(String className)
    {
        this.className = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
        attributes.add(new Attribute(name, type));
        return this;
    }
    
    public String toStringImp()
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("public class " + className + '\n' + '{');
    	for(Attribute att:attributes)
    	{
    		sb.append("\n"+
    				"   "  + "public " + att.type +  ' ' + att.name + ';');
    		
    	}
    	sb.append("\n"+"}");
    	return sb.toString();
    }
    
    @Override
    public String toString()
    {
        return toStringImp();
    }
}

class Demo{
	public static void main(String[] args) {
		CodeBuilder  cb = new CodeBuilder("Person")
				.addField("name", "String")
				.addField("age", "int");
		System.out.println(cb);
	}
}