package com.bqtn.events;

public enum EventType {
    TRADE() {
        @Override
        public void schedule() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'schedule'");
        }
    },
    USE_ON_SELF() {
        @Override
        public void schedule() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'schedule'");
        }
    },
    USE_ON_OTHER() {
        @Override
        public void schedule() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'schedule'");
        }
    },
    USE_ON_ITEM() {
        @Override
        public void schedule() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'schedule'");
        }
    },
    INTERACT_WITH() {
        @Override
        public void schedule() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'schedule'");
        }
    },
    TALK_TO() {
        @Override
        public void schedule() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'schedule'");
        }
    };

    public abstract void schedule();
}
