package org.jumpmind.db.platform.hana;

import java.sql.Types;

import org.jumpmind.db.model.Column;
import org.jumpmind.db.model.Table;
import org.jumpmind.db.platform.AbstractDdlBuilder;
import org.jumpmind.db.platform.DatabaseNamesConstants;
import org.jumpmind.db.platform.IDdlBuilder;

public class HanaDdlBuilder extends AbstractDdlBuilder implements IDdlBuilder {

    public HanaDdlBuilder() {
        super(DatabaseNamesConstants.HANA);
        databaseInfo.addNativeTypeMapping(Types.LONGVARBINARY, "BLOB", Types.BLOB);
        databaseInfo.addNativeTypeMapping(Types.LONGVARCHAR, "CLOB", Types.CLOB);
        
    }

    @Override
    protected void writeColumnAutoIncrementStmt(Table table, Column column, StringBuilder ddl) {
        ddl.append(" GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1) ");
    }

}
