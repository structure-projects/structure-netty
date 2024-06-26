package cn.structure.netty.exception;

/**
 * 执行器重复扫描
 */
public class InvokerRescanException extends RuntimeException {
	public InvokerRescanException(String message) {
		super("重复扫描执行器 :" + message);
	}
}
