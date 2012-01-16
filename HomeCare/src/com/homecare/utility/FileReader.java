package com.homecare.utility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileReader
{

	public static final String SCHEMA_NAME = "HOMECARE.";
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		List<String> tableName = new ArrayList<String>();
		List<String> columnName = new ArrayList<String>();
		List<String> dataType = new ArrayList<String>();
		List<String> size = new ArrayList<String>();
		List<String> isNull = new ArrayList<String>();
		List<String> constraint = new ArrayList<String>();
		List<String> createSQLList = new ArrayList<String>();
		List<String> createConstraintsList = new ArrayList<String>();
		StringBuffer createSQL = new StringBuffer();
		StringBuffer createPKConstraint = new StringBuffer();
		StringBuffer createFKConstraint = new StringBuffer();
		
		try
		{
			FileInputStream fstream = new FileInputStream("C:\\ParagonHHC\\New folder\\Database_Design.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while((strLine = br.readLine()) != null)
			{
				if(strLine.trim().length() == 0)
				{
					createTableSQL(tableName, columnName, dataType, size, isNull, constraint, createSQLList, createConstraintsList, createSQL, createPKConstraint, createFKConstraint);

					System.out.println("\n");

					tableName.clear();
					columnName.clear();
					dataType.clear();
					size.clear();
					isNull.clear();
					constraint.clear();
					createSQL = new StringBuffer();
					createPKConstraint = new StringBuffer();
					createFKConstraint = new StringBuffer();
					continue;
				}

				StringTokenizer st = new StringTokenizer(strLine, ",");
				readTokensAndAssign(tableName, columnName, dataType, size, isNull, constraint, st);
			}

			in.close();
		}
		catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}

	}

	private static void readTokensAndAssign(List<String> tableName, List<String> columnName, List<String> dataType, List<String> size, List<String> isNull, List<String> constraint, StringTokenizer st)
	{
		int i = 1;
		while(st.hasMoreTokens())
		{
			switch(i)
			{
				case 1:
					tableName.add(st.nextToken());
					break;
				case 2:
					columnName.add(st.nextToken());
					break;
				case 3:
					dataType.add(st.nextToken());
					break;
				case 4:
					size.add(st.nextToken());
					break;
				case 5:
					String nullable = "";
					if(st.nextToken().equals("Y"))
					{
						nullable = "NOT NULL";
					}
					isNull.add(nullable);
					break;
				case 6:
					constraint.add(st.nextToken());
					break;
				default:
					st.nextToken();
					break;
			}
			i++ ;
		}
	}

	private static void createTableSQL(List<String> tableName, List<String> columnName, List<String> dataType, List<String> size, List<String> isNull, List<String> constraint,
			List<String> createSQLList, List<String> createConstraintsList, StringBuffer createSQL, StringBuffer createPKConstraint, StringBuffer createFKConstraint)
	{
		createSQLString(tableName, columnName, dataType, size, isNull, createSQLList, createSQL);

		createPKConstraintString(tableName, columnName, constraint, createConstraintsList, createSQL, createPKConstraint);
		
		createFKConstraintString(tableName, columnName, constraint, createConstraintsList, createSQL, createFKConstraint);
	}

	private static void createPKConstraintString(List<String> tableName, List<String> columnName, List<String> constraint, List<String> createConstraintsList, StringBuffer createSQL,
			StringBuffer createPKConstraint)
	{
		createPKConstraint.append("ALTER TABLE ");
		createPKConstraint.append(SCHEMA_NAME);
		createPKConstraint.append(tableName.get(0));
		createPKConstraint.append(" ADD CONSTRAINT ");
		createPKConstraint.append(tableName.get(0) + "_PK");
		createPKConstraint.append(" PRIMARY KEY (");
		int pkCounter = 0;
		for(int j = 0; j < constraint.size(); j++ )
		{
			if(constraint.get(j) != null || constraint.get(j).trim().length() > 0)
			{
				if(constraint.get(j).trim().equals("PK"))
				{
					if(pkCounter > 0)
					{
						createPKConstraint.append(",");
					}
					createPKConstraint.append(columnName.get(j));
					pkCounter++ ;
				}
			}
		}
		createPKConstraint.append(");");
		if(constraint.size() != 0)
		{
			createConstraintsList.add(createPKConstraint.toString());
		}
		System.out.println(createPKConstraint.toString());
	}
	
	private static void createFKConstraintString(List<String> tableName, List<String> columnName, List<String> constraint, List<String> createConstraintsList, StringBuffer createSQL,
			StringBuffer createFKConstraint)
	{
		int k = 1;
		for(int j = 0; j < constraint.size(); j++ )
		{
			if(constraint.get(j) != null || constraint.get(j).trim().length() > 0)
			{
				if(constraint.get(j).trim().equals("FK"))
				{
					createFKConstraint.append("ALTER TABLE ");
					createFKConstraint.append(SCHEMA_NAME);
					createFKConstraint.append(tableName.get(0));
					createFKConstraint.append(" ADD CONSTRAINT ");
					createFKConstraint.append(tableName.get(0) + "_FK"+ k++);
					createFKConstraint.append(" FOREIGN KEY (");
					createFKConstraint.append(columnName.get(j));
					createFKConstraint.append(") REFERENCES ");
					createFKConstraint.append(SCHEMA_NAME);
					createFKConstraint.append(tableName.get(0).replaceAll("_AUDIT", ""));
					createFKConstraint.append(" (");
					createFKConstraint.append(columnName.get(j));
					createFKConstraint.append(");");
					
					System.out.println(createFKConstraint.toString());
					createConstraintsList.add(createFKConstraint.toString());
					createFKConstraint = new StringBuffer();
				}
			}
		}
	}

	private static void createSQLString(List<String> tableName, List<String> columnName, List<String> dataType, List<String> size, List<String> isNull, List<String> createSQLList,
			StringBuffer createSQL)
	{
		createSQL.append("CREATE TABLE ");
		createSQL.append(SCHEMA_NAME);
		createSQL.append(tableName.get(0));
		createSQL.append(" ( ");
		for(int j = 0; j < columnName.size(); j++ )
		{
			createSQL.append(columnName.get(j));
			createSQL.append(" ");
			createSQL.append(dataType.get(j));
			if(!(dataType.get(j).equals("DATE") || dataType.get(j).equals("BLOB")))
			{
				createSQL.append("(");
				createSQL.append(size.get(j));
				createSQL.append(")");
			}
			createSQL.append(" ");
			createSQL.append(isNull.get(j));
			if(j != columnName.size() - 1)
			{
				createSQL.append(",");
			}
		}
		createSQL.append(" );");
		createSQLList.add(createSQL.toString());
		System.out.println(createSQL.toString());
	}
}
