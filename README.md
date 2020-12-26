# Introduction
This is for Java JDBC

# 问题

## What is JDBC?
JDBC is java database connectivity as name implies it’s a java API for communicating to relational database,

## What are the main steps in java to make JDBC connectivity?
· Load the Driver: 

First step is to load the database specific driver which communicates with database.

· Make Connection: 

Next step is get connection from the database using connection object, which is used to send SQL statement also and get result back from the database.

· Get Statement object: 

From connection object we can get statement object which is used to query the database

· Execute the Query:

Using statement object we execute the SQL or database query and get result set from the query.

· Close the connection:

After getting resultset and all required operation performed the last step should be closing the database connection.

## What is JDBC Driver?
JDBC Driver is a software component that enables Java application to interact with the database. 

There are 4 types of JDBC drivers:

JDBC-ODBC bridge driver: 

The JDBC-ODBC bridge driver uses the ODBC driver to connect to the database. The JDBC-ODBC bridge driver converts JDBC method calls into the ODBC function calls. This is now discouraged because of the thin driver. It is easy to use and can be easily connected to any database.

Native-API driver (partially java driver): 

The Native API driver uses the client-side libraries of the database. The driver converts JDBC method calls into native calls of the database API. It is not written entirely in Java. Its performance is better than JDBC-ODBC bridge driver. However, the native driver must be installed on each client machine.

Network Protocol driver (fully java driver): 

The Network Protocol driver uses middleware (application server) that converts JDBC calls directly or indirectly into the vendor-specific database protocol. It is entirely written in Java. There is no requirement of the client-side library because of the application server that can perform many tasks like auditing, load balancing, logging, etc.

Thin driver (fully java driver): 

The thin driver converts JDBC calls directly into the vendor-specific database protocol. That is why it is known as the thin driver. It is entirely written in Java language. Its performance is better than all other drivers however these drivers depend upon the database.
## SQLException: No suitable driver found for jdbc:oracle:thin:@//localhost:1521/orcl
The "ojdbc.jar" is not in the CLASSPATH of your application server.

Just tell us which application server it is and we will tell you where the driver should be placed.

[参考](https://stackoverflow.com/questions/12103369/sqlexception-no-suitable-driver-found-for-jdbcoraclethin-localhost1521-or)

## What is the mean of “dirty read“ in database?
  It means read the value which may or may not be correct
  
  在数据库中，当一个事务正在执行并同时更改某个字段值时，又有另一个事务到来并在第一个事务提交或回滚该值之前读取更改字段值，这会导致该字段的值无效，这种情况称为脏读。 

## What is the 2 phase commit?
In simple word we can understand like if any transaction is executing and it will effect multiple database then two phase commit will be used to make all database synchronized with each other.

1. Commit request phase: in this phase main process or coordinator process take vote of all other process that they are complete their process successfully and ready to commit if all the votes are “yes” then they go ahead for next phase. And if “No “then rollback is performed.
2. Commit phase: according to vote if all the votes are yes then commit is done.

## What are different types of Statement?
There are three types of statement:
Statement，PreparedStatement, CallableStatement

PreparedStatement 和 Statement的区别在于 Statement#executeQuery每次都需要传递sql字符串，而PreparedStatement仅在创建时传递，可多次查询

1. Statement: it’s a commonly used for getting data from database useful when we are using static SQL statement at runtime. it will not accept any parameter.
      Statement   stmt = conn.createStatement( );
      ResultSet rs = stmt.executeQuery(sql);
    
2. PreparedStatement: when we are using same SQL statement multiple time its is useful and it will accept parameter at runtime.
   
              String SQL = "Update stock SET limit = ? WHERE stockType = ?";
      PreparedStatement  pstmt = conn.prepareStatement(SQL);
      ResultSet rs = pstmt.executeQuery();

3. Callable Statement: when we want to access stored procedures then callable statement are useful and they also accept runtime parameter. It is called like this
           
      CallableStatement cs = con.prepareCall("{call SHOW_SUPPLIERS}");
      ResultSet rs = cs.executeQuery();
    
详见Demo2, Demo5
## How cursor works in scrollable result set?
There are three constant define in result set by which we can move cursor.
· TYPE_FORWARD_ONLY: creates a nonscrollable result set, that is, one in which the cursor moves only forward
· TYPE_SCROLL_INSENSITIVE : a scrollable result set does not reflects changes that are made to it while it is open
· TYPE_SCROLL_SENSITIVE: a scrollable result set  reflects changes that are made to it while it is open

## What is connection pooling?

Connection pooling is the mechanism by which we reuse the recourse like connection objects  which are  needed to make connection with database .

## What do you mean by cold backup, hot backup?
冷备份就是在数据库关闭的情况下，备份数据库文件。

热备份就是在数据库打开的情况下，用sql语句备份数据库

## What are the differences between execute, executeQuery, and executeUpdate?

The execute method can be used for any SQL statements(Select and Update both).	

The execute method returns a boolean type value where true indicates that the ResultSet s returned which can later be extracted and false indicates that the integer or void value is returned.

详见Demo3

The executeQuery method can be used only with the select statement.	

The executeQuery() method returns a ResultSet object which contains the data retrieved by the select statement.	

The executeUpdate method can be used to update/delete/insert operations in the database.

The executeUpdate() method returns an integer value representing the number of records affected where 0 indicates that query returns nothing.

详见Demo4

## What is the role of the JDBC DriverManager class?
   The DriverManager class acts as an interface between user and drivers. 
   
   It keeps track of the drivers that are available and handles establishing a connection between a database and the appropriate driver. 
   
   The DriverManager class maintains a list of Driver classes that have registered themselves by calling the method DriverManager.registerDriver().

## What are the functions of the JDBC Connection interface?
   The Connection interface maintains a session with the database. 
   
   It can be used for transaction management. 
   
   It provides factory methods that return the instance of Statement, PreparedStatement, CallableStatement, and DatabaseMetaData.
 
 ## What does the JDBC ResultSetMetaData interface?
The ResultSetMetaData interface returns the information of table such as the total number of columns, column name, column type, etc.
 
## What does the JDBC DatabaseMetaData interface?
The DatabaseMetaData interface returns the information of the database such as username, driver name, driver version, number of tables, number of views, etc. Consider the following example. 

## Which interface is responsible for transaction management in JDBC?
The Connection interface provides methods for transaction management such as commit(), rollback() etc.

## What is the JDBC Rowset?
DBC Rowset is the wrapper of ResultSet. 

It holds tabular data like ResultSet, but it is easy and flexible to use. 

The implementation classes of RowSet interface are as follows:

JdbcRowSet

CachedRowSet

WebRowSet

JoinRowSet

FilteredRowSet

## What is the major difference between java.util.Date and java.sql.Date data type?
The major difference between java.util.Date and java.sql.Date is that, java.sql.Date represents date without time information whereas, java.util.Date represents both date and time information.

## What does JDBC setMaxRows method do?

The setMaxRows(int i) method limits the number of rows the database can return by using the query. This can also be done within the query as we can use the limit cause in MySQL.