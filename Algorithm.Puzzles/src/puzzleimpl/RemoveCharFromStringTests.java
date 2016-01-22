package puzzleimpl;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveCharFromStringTests {
	RemoveCharFromString removeCharFromString = new RemoveCharFromString();

	@Test
	public void removeBeginning() {
		assertEquals("bc", removeCharFromString.removeIterative("abc", 'a'));
		assertEquals("bc", removeCharFromString.removeRecursive("abc", 'a'));

		assertEquals("bcdefgh", removeCharFromString.removeIterative("abcdefgh", 'a'));
		assertEquals("bcdefgh", removeCharFromString.removeRecursive("abcdefgh", 'a'));

	}

	@Test
	public void removeMiddle() {
		assertEquals("aaaaaa", removeCharFromString.removeIterative("aaabaaa", 'b'));
		assertEquals("aaaaaa", removeCharFromString.removeRecursive("aaabaaa", 'b'));
	}

	@Test
	public void removeAtEnd() {
		assertEquals("abc", removeCharFromString.removeIterative("abcd", 'd'));
		assertEquals("abc", removeCharFromString.removeRecursive("abcd", 'd'));
	}

	@Test
	public void cornerCases() {
		// empty string test
		assertEquals("", removeCharFromString.removeIterative("", 'd'));
		assertEquals("", removeCharFromString.removeIterative("", 'd'));
		// all removable character test
		assertEquals("", removeCharFromString.removeIterative("aaaaaaaaaaaaaa", 'a'));
		assertEquals("", removeCharFromString.removeRecursive("aaaaaaaaaaaaaa", 'a'));
		// all but one removable characters
		assertEquals("b", removeCharFromString.removeIterative("aaaaaaaaaaaaaab", 'a'));
		assertEquals("b", removeCharFromString.removeRecursive("aaaaaaaaaaaaaab", 'a'));

	}
}