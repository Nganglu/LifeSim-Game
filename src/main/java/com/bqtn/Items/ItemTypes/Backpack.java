package com.bqtn.Items.ItemTypes;
import java.util.ArrayList;

import com.bqtn.Items.Item;
import com.bqtn.Items.ItemProperties.*;

public class Backpack implements Wearable, Container {
    
    @Override
    public int getCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCapacity'");
    }

    @Override
    public boolean isNested() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNested'");
    }

    @Override
    public ArrayList<Item> getContent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContent'");
    }
    
    @Override
    public boolean isCurrentlyWorn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCurrentlyWorn'");
    }

    @Override
    public int getThickness() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getThickness'");
    }

    @Override
    public int getInsulation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInsulation'");
    }


	@Override
	public int getTotalWeight() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTotalWeight'");
	}
}