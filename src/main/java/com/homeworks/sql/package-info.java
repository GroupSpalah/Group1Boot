/**
 * This package contains SQL scripts for creating and initializing the database schema.
 * It includes the necessary SQL statements for creating tables, setting up relationships,
 * and adding constraints (e.g., foreign keys, unique constraints) to ensure data integrity.
 * <p>
 * The SQL scripts are designed to work with MySQL and should be executed in the provided order
 * to ensure that the database structure is set up correctly.
 * </p>
 *
 * <h2>Package Contents:</h2>
 * <ul>
 * <li><b>ad_board_tables.sql</b>: This script contains SQL statements to create main tables in the database
 * using the JOINED approach, where each entity will have its own table. </li>
 * <li><b>ad_board_tables_address+email.sql</b>: This script contains SQL statements to create the main tables
 * in a database with partial use of the SINGLE_TABLE approach, namely for email and address entities,
 * in this case they will be placed in one table and all other entities will be placed in separate tables.
 * <p>
 * The latest version of the program is designed to work with this script.</li>
 * <h2>Execution Order:</h2>
 * <ol>
* <li>Run <code>ad_board_tables.sql</code> to create the initial tables
 * and the corresponding relationships between them using the JOINED entity placement approach.
 * <p>
 * In this case, you will need to change the code of the program for its correct operation.</li>
 * <li>
 * Run <code>ad_board_tables_address+email.sql</code> to create the initial tables and the corresponding
 * connections between them with partial use of the approach of placing SINGLE_TABLE entities.
 * <p>
 * It is recommended to use this script to exclude changes to the main application code.</li>
 * </ol>
 *
 * <h2>Database System Compatibility:</h2>
 * <p>
 * The SQL scripts are primarily written for MySQL, but they can be modified for use with other relational
 * databases by adjusting the syntax as needed.
 * </p>
 */
package com.homeworks.sql;