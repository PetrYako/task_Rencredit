/*
 Ctrl+Enter -> Console -> Ctrl+Enter (...)
 */

DROP TABLE IF EXISTS XmlWithOpenXML;

CREATE TABLE XmlWithOpenXML (
	Id INT IDENTITY PRIMARY KEY,
	XMLData XML
);

INSERT INTO XmlWithOpenXML(XMLData)
SELECT CONVERT(XML, BulkColumn) AS BulkColumn

/*
 Path to xml file
 */
FROM OPENROWSET (BULK 'D:\Git\ru.taskRencredit\test-output\testng-results.xml', SINGLE_BLOB) AS x;


DECLARE @XMLData AS XML
SELECT @XMLData = XMLData FROM XmlWithOpenXML;

SELECT Method = Node.Data.value('@name', 'varchar(max)'),
		Start_time = Node.Data.value('@started-at', 'varchar(max)'),
		End_time = Node.Data.value('@finished-at', 'varchar(max)'),
        Duration_ms = Node.Data.value('@duration-ms', 'varchar(max)')
FROM @XMLData.nodes('/testng-results/suite/test/class/test-method') Node(Data);

