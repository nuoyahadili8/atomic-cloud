/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.github.atomic.common.util.exception;

/**
 * @author lengleng
 * @date 2017-12-29 17:05:10
 * 403 授权拒绝
 */
public class AtomicDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AtomicDeniedException() {
    }

    public AtomicDeniedException(String message) {
        super(message);
    }

    public AtomicDeniedException(Throwable cause) {
        super(cause);
    }

    public AtomicDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtomicDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
