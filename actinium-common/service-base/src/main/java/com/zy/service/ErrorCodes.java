package com.zy.service;

public interface ErrorCodes {
    String BUSINESS_ERROR = "BusinessError";
    String DUPLICATE_KEY = "DuplicateKey";
    String DUPLICATE_SINGLE_KEY = "DuplicateSingleKey";
    String DUPLICATE_COMPOSITE_KEY = "DuplicateCompositeKey";
    String INVALID_ARGUMENT = "InvalidArgument";
    String INVALID_ARGUMENTS = "InvalidArguments";
    String INVALID_REQUEST = "InvalidRequest";
    String INVALID_SIGNATURE = "InvalidSignature";
    String INVALID_STATE = "InvalidState";
    String INVALID_VARIABLE = "InvalidVariable";
    String INTERNAL_SERVER_ERROR = "InternalServerError";
    String SERVER_ERROR = "ServerError";
    String UNSUPPORTED_CHARSET = "UnsupportedCharset";
    String UNSUPPORTED_OPERATION = "UnsupportedOperation";
    String OBJECT_ALREADY_EXISTS = "ObjectAlreadyExists";
    String MALFORMED_JSON = "MalformedJson";
}