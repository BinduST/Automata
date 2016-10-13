public class NonEmptyArgumentException extends RuntimeException {

    @Override
    public String getMessage() {
        String message = String.format("Expected Non-empty argument");
        return message;
    }
}