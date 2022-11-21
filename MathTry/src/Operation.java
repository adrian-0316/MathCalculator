enum Operation {
    SUM{
        @Override
        public int action(int x, int y) {
            return x + y;
        }
    },

    SUB{
        @Override
        public int action(int x, int y) {
            return x - y;
        }
    },

    MULT{
        @Override
        public int action(int x, int y) {
            return x * y;
        }
    },

    DIV{
        @Override
        public int action(int x, int y) {
            return x / y;
        }
    };

    public abstract int action(int x, int y);
}
