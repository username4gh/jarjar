/*
  Jar Jar Links - A utility to repackage and embed Java libraries
  Copyright (C) 2004  Tonic Systems, Inc.

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; see the file COPYING.  if not, write to
  the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA 02111-1307 USA
*/

package com.tonicsystems.jarjar;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.CodeVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;

public class NullClassVisitor
implements ClassVisitor
{
    private static final NullClassVisitor INSTANCE = new NullClassVisitor();

    public static NullClassVisitor getInstance()
    {
        return INSTANCE;
    }
    
    public void visit(int version, int access, String name, String superName, String[] interfaces, String sourceFile) { }
    public void visitEnd() { }
    public void visitField(int access, String name, String desc, Object value, Attribute attrs) { }
    public void visitInnerClass(String name, String outerName, String innerName, int access) { }
    public void visitAttribute(Attribute attrs) { }

    public CodeVisitor visitMethod(int access, String name, String desc, String[] exceptions, Attribute attrs)
    {
        return NullCodeVisitor.getInstance();
    }
}