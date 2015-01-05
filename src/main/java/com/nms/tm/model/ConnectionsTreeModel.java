/*
 * 2015 Next Generation Mobile Service JSC., (NMS).
 * All rights reserved.
 */
package com.nms.tm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.TreePath;

/**
 *
 * @author Cuong
 */
public class ConnectionsTreeModel extends AbstractTreeModel implements Serializable {

    private static final long serialVersionUID = 7609084178510972346L;

    private List<Connection> connections = new ArrayList<>();

    public ConnectionsTreeModel() {
    }
    
    private void loadConnection() {
        
    }

    @Override
    public Object getRoot() {
        return "Connections";
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof Connection) {
            Connection conn = (Connection) parent;
            if (conn.status == Connection.Status.Open) {
                return conn.threads.get(index);
            }
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof Connection) {
            Connection conn = (Connection) parent;
            if (conn.status == Connection.Status.Open) {
                return conn.threads.size();
            }
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return (node instanceof ThreadEntry);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof Connection) {
            Connection conn = (Connection) parent;
            ThreadEntry thread = (ThreadEntry) child;
            if (conn.status == Connection.Status.Open) {
                return conn.threads.indexOf(thread);
            }
        }
        return -1;
    }

}
