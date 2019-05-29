package com.gmail.shnapi007;

import java.util.Objects;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Assert;

public class DbUnitTest extends DbUnitBaseTest {


  public void testName() throws Exception {

    IDataSet databaseDataSet = this.getConnection().createDataSet();
    ITable actualTable = databaseDataSet.getTable("USER");

    for (int i = 0; i < actualTable.getRowCount(); i++) {
      System.out.println(actualTable.getValue(i, "first"));
      Assert.assertEquals(actualTable.getValue(i, "first"), "name" + (i + 1));
    }
  }

  public void testTableComparison() throws Exception {

    IDataSet databaseDataSet = this.getConnection().createDataSet();
    ITable actualTable = databaseDataSet.getTable("USER");

    IDataSet expectedDataSet = new FlatXmlDataSet(Objects
        .requireNonNull(this.getClass().getClassLoader().getResource("expectedDataset.xml")));

    ITable expectedTable = expectedDataSet.getTable("USER");
    ITable filteredActualTable = DefaultColumnFilter
        .includedColumnsTable(actualTable, expectedTable.getTableMetaData().getColumns());

    Assertion.assertEquals(expectedTable, filteredActualTable);
  }

}
