package com.storyteller.core.screen;

import com.storyteller.core.sentenceengine.verbs.Close;
import com.storyteller.core.sentenceengine.verbs.Give;
import com.storyteller.core.sentenceengine.verbs.LookAt;
import com.storyteller.core.sentenceengine.verbs.Open;
import com.storyteller.core.sentenceengine.verbs.PickUp;
import com.storyteller.core.sentenceengine.verbs.Pull;
import com.storyteller.core.sentenceengine.verbs.Push;
import com.storyteller.core.sentenceengine.verbs.TalkTo;
import com.storyteller.core.sentenceengine.verbs.Use;

public class ScreenBoxVerbs extends ScreenBox {

	public Open open;
	public Close close;
	public Give give;

	public PickUp pickUp;
	public LookAt lookAt;
	public TalkTo talkTo;

	public Push push;
	public Pull pull;
	public Use use;

	public ScreenBoxVerbs(ScreenCore screen) {
		super(screen);

		open = new Open();
		close = new Close();
		give = new Give();

		pickUp = new PickUp();
		lookAt = new LookAt();
		talkTo = new TalkTo();

		push = new Push();
		pull = new Pull();
		use = new Use();

		this.getBoxItems().add(open);
		this.getBoxItems().add(close);
		this.getBoxItems().add(give);
		this.getBoxItems().add(pickUp);
		this.getBoxItems().add(lookAt);
		this.getBoxItems().add(talkTo);
		this.getBoxItems().add(push);
		this.getBoxItems().add(pull);
		this.getBoxItems().add(use);
	}

}
