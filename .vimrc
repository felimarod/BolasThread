set number
set mouse=a
set numberwidth=1
set clipboard=unnamed
syntax enable
set showcmd
set ruler
set encoding=UTF-8
set showmatch
set sw=2
set rnu
set noshowmode

"revisa la sintaxis
execute pathogen#infect()
syntax on
filetype plugin indent on

let g:syntastic_java_checkers = ['checkstyle', 'javac']

set statusline+=%#warningmsg#
set statusline+=%{SyntasticStatuslineFlag()}
set statusline+=%*

let g:syntastic_auto_loc_list = 1
let g:syntastic_check_on_open = 1
let g:syntastic_check_on_wq = 0

call plug#begin()  

Plug 'vim-airline/vim-airline'
Plug 'vim-airline/vim-airline-themes'
Plug 'vim-ctrlspace/vim-ctrlspace'

"Temas
Plug 'dikiaap/minimalist'
Plug 'itchyny/lightline.vim'

"IDE
Plug 'easymotion/vim-easymotion'

"Busqueda de archivos
Plug 'junegunn/fzf', { 'do': { -> fzf#install() } }
Plug 'junegunn/fzf.vim'

"Autocompletado
Plug 'neoclide/coc.nvim', {'branch': 'release'}

"Arbol para navegar entre clases
Plug 'preservim/nerdtree'

call plug#end() 


"Estilo de sintaxis
set t_Co=256
syntax on
colorscheme minimalist

let NERDTreeQuitOnOpen=1

" Start NERDTree when Vim is started without file arguments.
autocmd StdinReadPre * let s:std_in=1
autocmd VimEnter * if argc() == 0 && !exists('s:std_in') | NERDTree | endif

" Exit Vim if NERDTree is the only window left.
autocmd BufEnter * if tabpagenr('$') == 1 && winnr('$') == 1 && exists('b:NERDTree') && b:NERDTree.isTabTree() |
    \ quit | endif

" Use tab for trigger completion with characters ahead and navigate.
" NOTE: Use command ':verbose imap <tab>' to make sure tab is not mapped by
" other plugin before putting this into your config.
inoremap <silent><expr> <TAB>
      \ pumvisible() ? "\<C-n>" :
      \ <SID>check_back_space() ? "\<TAB>" :
      \ coc#refresh()
inoremap <expr><S-TAB> pumvisible() ? "\<C-p>" : "\<C-h>"

function! s:check_back_space() abort
  let col = col('.') - 1
  return !col || getline('.')[col - 1]  =~# '\s'
endfunction



let mapleader=" "

" GoTo code navigation.
nmap <leader> gd <Plug>(coc-definition)
nmap <leader> gt <Plug>(coc-type-definition)
nmap <leader> gi <Plug>(coc-implementation)
nmap <leader> gr <Plug>(coc-references)

nmap <leader>r :!javac  *.java ; java Launcher<CR>
nmap <leader>s <Plug>(easymotion-s2)
nmap <leader>cs :CocSearch
nmap <leader>w :w<CR>
nmap <leader>q :wq<CR>

nmap <silent>nt :NERDTree<CR>
nmap <silent>nc :NERDTreeClose<CR>
nmap <silent>nf :NERDTreeFind<CR>

inoremap <silent>ii <esc>

