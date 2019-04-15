$.fn.deletePanel = function(opt) {
	
	var self = this;
	var templ = `
	<form class="my-3">
		비밀번호 :
		<input type="password" name="password" required>
		<button type="submit" class="btn btn-primary btn-sm">
			<i class="fas fa-times"></i> 삭제
		</button>
		<button type="button" class="btn btn-primary btn-sm cancel">
			<i class="fas fa-undo"></i> 취소
		</button>
	</form>`;
	
	self.hide();
	self.append(templ);
	var password = self.find(':password');
	var triger = $(opt.triger);
	var url;
	var items = [];
	triger.click(function(){
		var userId = $(this).data('user-id');
		if(userId)
			url = opt.url.replace('{user-id}', userId );
		else{
			if($(this).data('mode')=='multiple'){
				$(opt.multiple).each(function(){
					items.push($(this).val());
				});
				url = opt.url.replace('delete/{user-id}', 'multi_delete');
			}
			else{
				url = opt.url;
			}
		}
		self.show();
	});
	
	self.on('click', '.cancel', ()=>{
		password.val('');
		self.hide();
	}); 
	
	self.on('submit', 'form', function(e) {
		e.preventDefault();
		if(!confirm("삭제할까요?")) 
			return;
		
		if(items[0]){
			url = url + '/' + items.join('&');
		}
		axios.delete(url + '?password=' + password.val()).then(function(obj) {
			alert(obj.data.message);
			if(obj.data.result == 'success') {	
				location = opt.moveUrl; } 
			}) .catch(console.log);
	}); 
}