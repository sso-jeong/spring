package com.greenart.grp.paging;

public class Pager {
	private int PAGE_SCALE = 10; // �� ������ �Խù� ����
	private int BLOCK_SCALE = 10; // ���� �������� ������ ��ȣ ����

	private int curPage; // Ŭ������ �� ���� ������
	private int prevPage; // ���� ������
	private int nextPage; // ���� ������
	private int totPage; // ��ü ������

	// �� ��� �̵��� ��
	private int curBlock;
	private int prevBlock;
	private int nextBlock;
	private int totBlock;

	// �� ó�� �Ǵ� �� �� �������� �̵��� ��
	private int pageBegin;
	private int pageEnd;

	// �� ó�� �Ǵ� �� �� ������� �̵��� ��
	private int blockBegin;
	private int blockEnd;
	
	// ������ ������
	public Pager(int count, int curPage) {
		this.curPage = curPage;
		// this ����������, super �θ�
		// this(), super()
		curBlock = 1;
		
		setTotPage(count);
		setTotBlock();
		
		setPageRange(curPage);
		setBlockRange();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int count) {
		totPage = (int) Math.ceil(count * 1.0 / PAGE_SCALE);
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock(int totBlock) {
		this.totBlock = totBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
	public void setTotBlock() {
		totBlock = (int) Math.ceil(totPage / BLOCK_SCALE);
	}
	
	public void setPageRange(int curPage) {
		pageBegin = (curPage -1) * PAGE_SCALE;		
		pageEnd = (int) (Math.ceil( curPage / (double) PAGE_SCALE ) * PAGE_SCALE);
	}
	
	public void setBlockRange() {
		curBlock = (int) Math.ceil( (curPage - 1) / BLOCK_SCALE ) + 1;
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		
		if( blockEnd > totPage ) blockEnd = totPage; // �б�
		
		prevPage = ( curPage == 1 ) ? 1 : (curPage - 1 ) * BLOCK_SCALE; // ���ǹ� ? �� : ����
		nextPage = curBlock > totBlock ? ( curBlock * BLOCK_SCALE ) : ( curBlock * BLOCK_SCALE ) + 1; // ���ǹ� ? �� : ����
		
		if( nextPage >= totPage ) nextPage = totPage;
	}

}
