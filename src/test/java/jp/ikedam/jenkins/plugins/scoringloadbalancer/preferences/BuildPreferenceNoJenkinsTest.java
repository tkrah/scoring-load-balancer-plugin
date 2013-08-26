/*
 * The MIT License
 * 
 * Copyright (c) 2013 IKEDA Yasuyuki
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jp.ikedam.jenkins.plugins.scoringloadbalancer.preferences;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 */
public class BuildPreferenceNoJenkinsTest
{
    @Test
    public void testBuildPreference()
    {
        {
            BuildPreference target = new BuildPreference("node1", 10);
            assertEquals("node1", target.getLabelExpression());
            assertEquals(10, target.getPreference());
        }
        
        {
            BuildPreference target = new BuildPreference("node2 && node3", -20);
            assertEquals("node2 && node3", target.getLabelExpression());
            assertEquals(-20, target.getPreference());
        }
        
        {
            BuildPreference target = new BuildPreference(null, 0);
            assertEquals(null, target.getLabelExpression());
            assertEquals(0, target.getPreference());
        }
        
        {
            BuildPreference target = new BuildPreference("", 0);
            assertEquals("", target.getLabelExpression());
            assertEquals(0, target.getPreference());
        }
        
        {
            BuildPreference target = new BuildPreference("  ", 0);
            assertEquals("", target.getLabelExpression());
            assertEquals(0, target.getPreference());
        }
        
        {
            BuildPreference target = new BuildPreference(" a && b ", 0);
            assertEquals("a && b", target.getLabelExpression());
            assertEquals(0, target.getPreference());
        }
    }
}