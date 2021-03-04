/**
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.util.gui;

import java.awt.Component;
import static java.util.Objects.requireNonNull;
import java.util.function.Function;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Renders values to JLabels.
 *
 * @author Mustafa Yalciner (Fraunhofer IML)
 * @param <E> The type of the values to be rendered.
 */
public class StringListCellRenderer<E>
    extends JLabel
    implements ListCellRenderer<E> {

  /**
   * Returns a String representation of E.
   */
  private final Function<E, String> representer;

  /**
   * Creates an instance.
   *
   * @param representer a string representation provider for the values of the list.
   * Null value as parameter for the representer is possible.
   * The result is set as text of the JLabel.
   */
  public StringListCellRenderer(Function<E, String> representer) {
    this.representer = requireNonNull(representer, "representer");
    setOpaque(true);
  }

  @Override
  public Component getListCellRendererComponent(
      JList<? extends E> list,
      E value,
      int index,
      boolean isSelected,
      boolean cellHasFocus) {
    setText(representer.apply(value));
    return this;
  }
}
