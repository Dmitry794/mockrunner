package com.mockrunner.test;

import com.mockrunner.base.NestedApplicationException;

import junit.framework.TestCase;

public class NestedApplicationExceptionTest extends TestCase
{
    private NestedApplicationException nested;
    private Exception exception;
    
    protected void setUp() throws Exception
    {
        super.setUp();
        exception = new Exception();
        nested = new NestedApplicationException(new NestedApplicationException(exception));
    }
    
    public void testGetNested()
    {
        assertNotSame(exception, nested.getNested());
        assertTrue(nested.getNested() instanceof NestedApplicationException);
    }
    
    public void testGetRootCause()
    {
        assertSame(exception, nested.getRootCause());
    }
}
