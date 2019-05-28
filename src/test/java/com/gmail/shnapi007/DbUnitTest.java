package com.gmail.shnapi007;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
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

}
