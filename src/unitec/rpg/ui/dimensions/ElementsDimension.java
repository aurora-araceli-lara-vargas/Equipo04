package unitec.rpg.ui.dimensions;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface ElementsDimension {

    int MARGIN = 15;
    EmptyBorder MARGIN_BORDER = new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN);
    Dimension WINDOW_SIZE = new Dimension(1280, 720);
    Dimension TOP_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), 234);
    Dimension BOTTOM_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), 50);
    Dimension CENTER_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), WINDOW_SIZE.height
            - (2 * MARGIN) - TOP_PANEL_SIZE.height - BOTTOM_PANEL_SIZE.height);
}