package com.mockrunner.gen;

import java.util.HashMap;
import java.util.Map;

import com.mockrunner.gen.proc.JavaLineProcessor;

public class JDKVersionGenerator extends AbstractVersionGenerator
{
    public static void main(String[] args) throws Exception
    {
        JDKVersionGenerator synchVersionUtil = new JDKVersionGenerator();
        synchVersionUtil.doSynchronize();
    }
    
    protected String getGeneratorName()
    {
        return "JDBC JDK1.3";
    }
    
    protected String getRootTargetDir()
    {
        return "src1.3";
    }
    
    protected String getRootSourceDir()
    {
        return "src";
    }
    
    protected String[] getProcessedPackages()
    {
        return new String[] {"com/mockrunner/jdbc", "com/mockrunner/mock/jdbc"};
    }
    
    protected Map prepareProcessorMap()
    {
        Map jdbcFiles = new HashMap();
        
        JavaLineProcessor mockConnectionProc = new JavaLineProcessor();
        mockConnectionProc.addLine("import java.sql.Savepoint");
        mockConnectionProc.addLine("private int holdability;");
        mockConnectionProc.addLine("holdability = ResultSet.HOLD_CURSORS_OVER_COMMIT;");
        mockConnectionProc.addBlock("public int getHoldability()");
        mockConnectionProc.addBlock("public void setHoldability(int holdability)");
        mockConnectionProc.addBlock("public Savepoint setSavepoint()");
        mockConnectionProc.addBlock("public Savepoint setSavepoint(String name)");
        mockConnectionProc.addBlock("public void releaseSavepoint(Savepoint savepoint)");
        mockConnectionProc.addBlock("public void rollback(Savepoint savepoint)");
        jdbcFiles.put("com.mockrunner.mock.jdbc.MockConnection", mockConnectionProc);
        
        JavaLineProcessor mockDatabaseMetadataProc = new JavaLineProcessor();
        mockDatabaseMetadataProc.addLine("private int sqlStateType = sqlStateSQL99;");
        mockDatabaseMetadataProc.addBlock("public int getSQLStateType()");
        mockDatabaseMetadataProc.addBlock("public void setSQLStateType(int sqlStateType)");
        jdbcFiles.put("com.mockrunner.mock.jdbc.MockDatabaseMetaData", mockDatabaseMetadataProc);
        
        JavaLineProcessor mockPreparedStatementProc = new JavaLineProcessor();
        mockPreparedStatementProc.addLine("import java.sql.ParameterMetaData;");
        mockPreparedStatementProc.addLine("private MockParameterMetaData parameterMetaData;");
        mockPreparedStatementProc.addLine("prepareParameterMetaData();");
        mockPreparedStatementProc.addLine("prepareParameterMetaData();");
        mockPreparedStatementProc.addLine("prepareParameterMetaData();");
        mockPreparedStatementProc.addBlock("private void prepareParameterMetaData()");
        mockPreparedStatementProc.addBlock("public ParameterMetaData getParameterMetaData()");
        jdbcFiles.put("com.mockrunner.mock.jdbc.MockPreparedStatement", mockPreparedStatementProc);
        
        JavaLineProcessor mockStatementProc = new JavaLineProcessor();
        mockStatementProc.addLine("private int resultSetHoldability = ResultSet.HOLD_CURSORS_OVER_COMMIT;");
        mockStatementProc.addBlock("try");
        mockStatementProc.addBlock("catch(SQLException exc)");
        mockStatementProc.addBlock("try");
        mockStatementProc.addBlock("catch(SQLException exc)");
        mockStatementProc.addLine("this.resultSetHoldability = resultSetHoldability;");
        mockStatementProc.addBlock("public int getResultSetHoldability()");
        jdbcFiles.put("com.mockrunner.mock.jdbc.MockStatement", mockStatementProc);
        
        JavaLineProcessor jdbcTestCaseAdapterProc = new JavaLineProcessor();
        jdbcTestCaseAdapterProc.addLine("import com.mockrunner.mock.jdbc.MockSavepoint;");
        jdbcTestCaseAdapterProc.addBlock("protected List getSavepoints()");
        jdbcTestCaseAdapterProc.addBlock("protected MockSavepoint getSavepoint(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected MockSavepoint getSavepoint(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointPresent(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointPresent(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointReleased(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointReleased(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointNotReleased(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointNotReleased(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointRollbacked(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointRollbacked(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointNotRollbacked(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointNotRollbacked(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointRolledBack(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointRolledBack(String name)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointNotRolledBack(int index)");
        jdbcTestCaseAdapterProc.addBlock("protected void verifySavepointNotRolledBack(String name)");
        jdbcFiles.put("com.mockrunner.jdbc.JDBCTestCaseAdapter", jdbcTestCaseAdapterProc);
        jdbcFiles.put("com.mockrunner.jdbc.BasicJDBCTestCaseAdapter", jdbcTestCaseAdapterProc);
        
        JavaLineProcessor jdbcTestModuleProc = new JavaLineProcessor();
        jdbcTestModuleProc.addLine("import com.mockrunner.mock.jdbc.MockSavepoint;");
        jdbcTestModuleProc.addBlock("public List getSavepoints()");
        jdbcTestModuleProc.addBlock("public MockSavepoint getSavepoint(int index)");
        jdbcTestModuleProc.addBlock("public MockSavepoint getSavepoint(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointPresent(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointPresent(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointReleased(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointReleased(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointNotReleased(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointNotReleased(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointRollbacked(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointRollbacked(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointNotRollbacked(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointNotRollbacked(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointRolledBack(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointRolledBack(String name)");
        jdbcTestModuleProc.addBlock("public void verifySavepointNotRolledBack(int index)");
        jdbcTestModuleProc.addBlock("public void verifySavepointNotRolledBack(String name)");
        jdbcFiles.put("com.mockrunner.jdbc.JDBCTestModule", jdbcTestModuleProc);
        
        jdbcFiles.put("com.mockrunner.mock.jdbc.MockSavepoint", new Boolean(false));
        jdbcFiles.put("com.mockrunner.mock.jdbc.MockParameterMetaData", new Boolean(false));
        
        return jdbcFiles;
    }
}
