package com.bqtn.Events;

public enum EventType {
    USE_ON_SELF() {
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    },
    USE_ON_OTHER() {
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    },
    USE_ON_ITEM() {
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    },
    INTERACT_WITH() {
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    },
    TALK_TO() {
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    };

    public abstract void execute();
}
