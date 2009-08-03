/*******************************************************************************
 * Copyright 2009 OmniDroid - http://code.google.com/p/omnidroid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package edu.nyu.cs.omnidroid.util;

import junit.framework.TestCase;

/**
 * Unit tests for {@link Tree} class.
 */
public class TreeTest extends TestCase {
  private Tree<Integer> tree;

  @Override
  public void setUp() {
    tree = generateTree(5);
  }

  /**
   * Tests that two trees with the same structure and node data are equal
   */
  public void testEqual() {
    Tree<Integer> sameTree = generateTree(5);
    assertEquals(tree, sameTree);
  }

  /**
   * Tests that two trees with a different structure and node data are not equal
   */
  public void testNotEqual() {
    Tree<Integer> differentTree = generateTree(12);
    assertFalse(tree.equals(differentTree));
  }

  /**
   * Tests that two equal trees have the same hash code
   */
  public void testEqualHashCode() {
    Tree<Integer> sameTree = generateTree(5);
    assertEquals(tree.hashCode(), sameTree.hashCode());
  }

  /**
   * Tests that two different trees (probably) do not have the same hash code
   */
  public void testNotEqualHashCode() {
    Tree<Integer> differentTree = generateTree(17);
    assertFalse(tree.hashCode() == differentTree.hashCode());
  }

  /**
   * Generate a tree of integers for testing purposes
   * 
   * @param k
   *          starting number for the data field of the second level children
   * @return a tree of Integers
   */
  private Tree<Integer> generateTree(int k) {
    Tree<Integer> aTree = new Tree<Integer>(null, 1);
    for (int i = 2; i < 4; i++) {
      aTree.addChild(i);
      int j = k;
      for (; j < k + 3; j++) {
        aTree.addChild(j);
      }
      k = j;
    }
    return aTree;
  }
}